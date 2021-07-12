module F = Format

(* practice & homework *)
let rec interp_e (e : Ast.expr) ((env, mem) : Env.t * Mem.t) : Mem.value =
    match e with
    | Num(num) -> NumV(num)
    | Var(parm) -> Mem.find (Env.find parm env) mem
    | Ref(parm) -> AddressV(Env.find parm env)
    | Deref(addr) ->
        begin match (Mem.find (Env.find addr env) mem) with
        | AddressV(address) ->
            Mem.find address mem
        | _-> failwith (Format.asprintf "Not a memory address %s" addr)
        end
    | Bool(bool) -> BoolV(bool)
    | Add (ex1, ex2) ->
        begin match ((interp_e ex1 (env, mem)), (interp_e ex2 (env, mem))) with
        | (NumV (n1), NumV(n2)) -> NumV(n1+n2)
        | (_, _) -> failwith (Format.asprintf "Invalid addition: %a + %a" Ast.pp_e ex1 Ast.pp_e ex2)
        end
    | Sub (ex1, ex2) ->
        begin match ((interp_e ex1 (env, mem)), (interp_e ex2 (env, mem))) with
        | (NumV (n1), NumV(n2)) -> NumV(n1-n2)
        | (_, _) -> failwith (Format.asprintf "Invalid subtraction: %a - %a" Ast.pp_e ex1 Ast.pp_e ex2)
        end
    | Lt (ex1, ex2) ->
        begin match ((interp_e ex1 (env, mem)), (interp_e ex2 (env, mem))) with
        | (NumV (n1), NumV(n2)) -> if (n1 < n2) then BoolV(true) else BoolV(false)
        | (_, _) -> failwith (Format.asprintf "Invalid less-than: %a < %a" Ast.pp_e ex1 Ast.pp_e ex2)
        end
    | Gt (ex1, ex2) ->
        begin match ((interp_e ex1 (env, mem)), (interp_e ex2 (env, mem))) with
        | (NumV (n1), NumV(n2)) -> if (n1 > n2) then BoolV(true) else BoolV(false)
        | (_, _) -> failwith (Format.asprintf "Invalid greater-than: %a > %a" Ast.pp_e ex1 Ast.pp_e ex2)
        end
    | Eq (ex1, ex2) ->
        begin match ((interp_e ex1 (env, mem)), (interp_e ex2 (env, mem))) with
        | (NumV (n1), NumV(n2)) -> if (n1 == n2) then BoolV(true) else BoolV(false)
        | (BoolV (b1), BoolV(b2)) -> if (b1 == b2) then BoolV(true) else BoolV(false)
        | (_, _) -> failwith (Format.asprintf "Invalid equal-to: %a = %a" Ast.pp_e ex1 Ast.pp_e ex2)
        end
    | And (ex1, ex2) ->
        begin match ((interp_e ex1 (env, mem)), (interp_e ex2 (env, mem))) with
        | (BoolV (b1), BoolV(b2)) -> if (b1 = true && b2 = true) then BoolV(true) else BoolV(false)
        | (_, _) -> failwith (Format.asprintf "Invalid logical-and: %a && %a" Ast.pp_e ex1 Ast.pp_e ex2)
        end
    | Or (ex1, ex2) ->
        begin match ((interp_e ex1 (env, mem)), (interp_e ex2 (env, mem))) with
        | (BoolV (b1), BoolV(b2)) -> if (b1 = true || b2 = true) then BoolV(true) else BoolV(false)
        | (_, _) -> failwith (Format.asprintf "Invalid logical-or: %a || %a" Ast.pp_e ex1 Ast.pp_e ex2)
        end

(* practice & homework *)
let rec interp_s (stmt : Ast.stmt) ((env, mem) : Env.t * Mem.t) : Env.t * Mem.t =
    let rec allInterpStmtlist stlt (env,mem) =
        begin match stlt with
        | [] -> (env,mem)
        | stmt::nextlist ->
            allInterpStmtlist nextlist (interp_s stmt (env,mem))
        end
    in
    match stmt with
    | VarDeclStmt (parm)->
        if (Env.mem parm env) then failwith (Format.asprintf "%s is already declared" parm)
        else ((Env.insert parm (Env.new_address ()) env),mem)
    | StoreStmt (parm, expr) ->
        begin match (interp_e parm (env, mem)) with
        | AddressV(addr) ->
            (env, (Mem.insert addr (interp_e expr (env, mem)) mem))
        | _-> failwith (Format.asprintf "Not a memory address : %a" Ast.pp_e parm)
        end
    | IfStmt (expr, stmtlist, option)->
        begin match (interp_e expr (env,mem)) with
            | BoolV (true) ->
                allInterpStmtlist stmtlist (env,mem)
            | BoolV (false) ->
                begin match option with
                    | None -> (env,mem)
                    | Some (falseStmtList) ->
                        allInterpStmtlist falseStmtList (env,mem)
                end
            | _ -> failwith (Format.asprintf "Not a boolean %a" Ast.pp_e expr)
        end
    | WhileStmt (expr, stmtlist) ->
        match (interp_e expr (env, mem)) with
        | BoolV (true) ->
            interp_s (WhileStmt(expr,stmtlist)) (allInterpStmtlist stmtlist (env,mem))
        | BoolV (false) -> (env, mem)
        | _ -> failwith (Format.asprintf "Not a boolean %a" Ast.pp_e expr)


(* practice & homework *)
let interp (p : Ast.program) : Env.t * Mem.t =
    match p with
    | Program(stmlist) ->
        let rec allInterpStmtlist stlt (env,mem) =
            begin match stlt with
            | [] -> (env,mem)
            | stmt::nextlist ->
                allInterpStmtlist nextlist (interp_s stmt (env,mem))
            end
        in allInterpStmtlist stmlist ([],[])

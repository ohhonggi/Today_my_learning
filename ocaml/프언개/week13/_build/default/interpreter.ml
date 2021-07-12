module F = Format

(* practice & homework *)
let rec interp_e (e : Ast.expr) (s : Store.t) : Store.value = 
    match e with
    | Num (n) -> NumV(n)
    | Var (parm) -> Store.find parm s
    | Bool (bool) -> BoolV(bool)
    | Add (ex1, ex2) ->
        begin match ((interp_e ex1 s), (interp_e ex2 s)) with
        | (NumV (n1), NumV(n2)) -> NumV(n1+n2)
        | (_, _) -> failwith (Format.asprintf "Invalid addition: %a + %a" Ast.pp_e ex1 Ast.pp_e ex2)
        end
    | Sub (ex1, ex2) ->
        begin match ((interp_e ex1 s), (interp_e ex2 s)) with
        | (NumV (n1), NumV(n2)) -> NumV(n1-n2)
        | (_, _) -> failwith (Format.asprintf "Invalid subtraction: %a - %a" Ast.pp_e ex1 Ast.pp_e ex2)
        end
    | Lt (ex1, ex2) ->
        begin match ((interp_e ex1 s), (interp_e ex2 s)) with
        | (NumV (n1), NumV(n2)) -> if (n1 < n2) then BoolV(true) else BoolV(false)
        | (_, _) -> failwith (Format.asprintf "Invalid less-than: %a < %a" Ast.pp_e ex1 Ast.pp_e ex2)
        end
    | Gt (ex1, ex2) ->
        begin match ((interp_e ex1 s), (interp_e ex2 s)) with
        | (NumV (n1), NumV(n2)) -> if (n1 > n2) then BoolV(true) else BoolV(false)
        | (_, _) -> failwith (Format.asprintf "Invalid greater-than: %a > %a" Ast.pp_e ex1 Ast.pp_e ex2)
        end
    | Eq (ex1, ex2) ->
        begin match ((interp_e ex1 s), (interp_e ex2 s)) with
        | (NumV (n1), NumV(n2)) -> if (n1 == n2) then BoolV(true) else BoolV(false)
        | (BoolV (b1), BoolV(b2)) -> if (b1 == b2) then BoolV(true) else BoolV(false)
        | (_, _) -> failwith (Format.asprintf "Invalid equal-to: %a = %a" Ast.pp_e ex1 Ast.pp_e ex2)
        end
    | And (ex1, ex2) ->
        begin match ((interp_e ex1 s), (interp_e ex2 s)) with
        | (BoolV (b1), BoolV(b2)) -> if (b1 = true && b2 = true) then BoolV(true) else BoolV(false)
        | (_, _) -> failwith (Format.asprintf "Invalid logical-and: %a && %a" Ast.pp_e ex1 Ast.pp_e ex2)
        end
    | Or (ex1, ex2) ->
        begin match ((interp_e ex1 s), (interp_e ex2 s)) with
        | (BoolV (b1), BoolV(b2)) -> if (b1 = true || b2 = true) then BoolV(true) else BoolV(false)
        | (_, _) -> failwith (Format.asprintf "Invalid logical-or: %a || %a" Ast.pp_e ex1 Ast.pp_e ex2)
        end

(* practice & homework *)
let rec interp_s (stmt : Ast.stmt) (s : Store.t) : Store.t =
    match stmt with
    | AssignStmt (parm, expr) ->
        Store.insert parm (interp_e expr s) s
    | IfStmt (expr, stmtList, option) ->
        let rec recurStmtList stList store =
            begin match stList with
            | stmt :: nextList -> (recurStmtList nextList (interp_s stmt store))
            | [] -> store
            end
        in
        begin match (interp_e expr s) with
            | BoolV(true) ->
                recurStmtList stmtList s
            | BoolV(false) ->
                begin match option with
                | None -> s
                | Some (falseStmtList) ->
                    recurStmtList falseStmtList s
                end
            | NumV (_) -> failwith (Format.asprintf "Not a boolean: %a" Ast.pp_e expr)
        end
  

(* practice & homework *)
let interp (p : Ast.program) : Store.t =
    match p with
    | Program (stmtlist) ->
        let rec allStmtCal stList store =
            begin match stList with
            | stmt :: nextList -> (allStmtCal nextList (interp_s stmt store))
            | [] -> store
            end
        in allStmtCal stmtlist []

  

module F = Format

(* practice & homework *)
let rec interp_e (s : Store.t) (e : Ast.expr) : Store.value = 
    match e with
    | Num (num) -> NumV(num)
    | Add (ex1, ex2) ->
        let va1 = (interp_e s ex1) in
        let va2 = (interp_e s ex2) in
        begin match (va1, va2) with
        | (NumV (n1), NumV (n2)) -> NumV(n1 + n2)
        | (_,_) -> failwith (Format.asprintf "addition vaild %a + %a" Ast.pp_e ex1 Ast.pp_e ex2)
        end
    | Sub (ex1, ex2) ->
        let va1 = (interp_e s ex1) in
        let va2 = (interp_e s ex2) in
        begin match (va1, va2) with
        | (NumV (n1), NumV (n2)) -> NumV(n1 - n2)
        | (_,_) -> failwith (Format.asprintf "subtraction vaild %a - %a" Ast.pp_e ex1 Ast.pp_e ex2)
        end
    | Id (exN) ->
        let extoid = Store.find exN s in
        begin match extoid with
            | FreezedV (exF, fS) -> interp_e fS exF
            | _ -> extoid
        end
    | LetIn (parm, ex1, ex2) ->
        let va1 = (interp_e s ex1) in
        interp_e (Store.insert parm va1 s) ex2
    | RLetIn (parm, ex1, ex2) ->
        let va1 = (interp_e s ex1) in
        begin match va1 with
        | ClosureV (parmV, expr, ex1S) ->
(*            let rec ex1DS = (Store.insert parm (Store.ClosureV(parmV, expr, ex1DS)) ex1S) in*)
            let rec ex1DS = (parm, (Store.ClosureV(parmV, expr, ex1DS))) :: ex1S in
            interp_e ex1DS ex2
        | _ -> failwith (Format.asprintf "Not a function %a" Ast.pp_e ex1)
        end
    | App (ex1, ex2) ->
        begin match (interp_e s ex1) with
        | ClosureV (parm, body, ex1S) ->
            interp_e (Store.insert parm (Store.FreezedV(ex2, s)) ex1S) body
        | _ -> failwith (Format.asprintf "Not a function %a" Ast.pp_e ex1)
        end
    | Fun (parm, ex1) -> ClosureV(parm, ex1, s)
    | Lt (ex1, ex2) ->
        let va1 = interp_e s ex1 in
        let va2 = interp_e s ex2 in
        begin match (va1, va2) with
        | (NumV (n1), NumV(n2)) ->
            if (n1 < n2) then ClosureV ("x",Fun("y",Id("x")),[])
            else ClosureV("x", Fun("y",Id("y")) ,[])
        | (_,_) -> failwith (Format.asprintf "Invalid less-than: %a < %a" Ast.pp_e ex1 Ast.pp_e ex2)
        end
(* practice & homework *)
let interp (p : Ast.fvae) : Store.value =
    match p with
    | Prog (ex)-> interp_e [] ex

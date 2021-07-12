module F = Format

(* practice & homework *)
let rec interp_e (s : Store.t) (e : Ast.expr) : Store.value =
    match e with
    | Num (expI) -> NumV(expI)
    | Add (ex1, ex2) ->
        let val1 = interp_e s ex1 in
        let val2 = interp_e s ex2 in
        begin match (val1, val2) with
        | (NumV (v1), NumV (v2)) -> NumV(v1 + v2)
        | (_,_) -> failwith (Format.asprintf "Invalid addition: %a + %a" Ast.pp_e ex1 Ast.pp_e ex2)
        end
    | Sub (ex1, ex2) ->
        let val1 = interp_e s ex1 in
        let val2 = interp_e s ex2 in
        begin match (val1, val2) with
        | (NumV (v1), NumV(v2)) -> NumV(v1 - v2)
        | (_,_) -> failwith (Format.asprintf "Invalid subtraction: %a - %a" Ast.pp_e ex1 Ast.pp_e ex2)
        end
    | Id (expN) -> Store.find expN s
    | LetIn (funN, ex1, ex2) ->
        let val1 = interp_e s ex1 in
        interp_e (Store.insert funN val1 s) ex2
    | App (ex1, ex2) ->
        let val2 = (interp_e s ex2) in
        begin match (interp_e s ex1) with
        | ClosureV (parm, ex1E, ex1S) ->
            interp_e (Store.insert parm val2 ex1S) ex1E
        | NumV (_)-> failwith (Format.asprintf "Not a function: %a" Ast.pp_e ex1)
        end
    | Fun (parm, body) ->
        ClosureV (parm, body, s)


(* practice & homework *)
let interp (p : Ast.fvae) : Store.value =
    match p with
    | Prog (expr) -> interp_e [] expr

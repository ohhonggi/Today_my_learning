module F = Format

let interp_d (fd : Ast.fundef) : FEnv.t =
    match fd with
    | Ast.FDef(funN, param, body)
        -> FEnv.insert funN param body []
	(* write your code *)

let rec interp_e (fenv : FEnv.t) (s : Store.t) (e : Ast.expr) : int =
    match e with
    | Num num -> num
    | Id n -> interp_e fenv s (Num(Store.find n s))
    | Add(n1,n2) ->
        (interp_e fenv s n1) + (interp_e fenv s n2)
    | Sub(n1,n2) ->
        (interp_e fenv s n1) - (interp_e fenv s n2)
    | LetIn (x,n1,n2) ->
        interp_e fenv (Store.insert x (interp_e fenv s n1) s) n2
    | FCall (funN, expr) ->
        match (FEnv.find funN fenv) with
        | (param, body) ->
            let storeN = interp_e fenv s expr in
            interp_e fenv (Store.insert param storeN s) body

(* practice *)
let interp (p : Ast.f1vae) : int =
    match p with
    | Ast.Prog (fundef, expr) ->
        interp_e (interp_d fundef) [] expr
	(* write your code *)

module F = Format

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

let interp_d (fenv : FEnv.t) (fd : Ast.fundef) : FEnv.t = 
  (* write your code *)

(* practice *)
let interp (p : Ast.f1vae) : int = 
  (* write your code *)

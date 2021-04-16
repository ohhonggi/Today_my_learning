module F = Format
module S = Store

(* practice *)
let rec interp (s: Store.t) (e : Ast.vae) : int =
    match e with
(*    | Neg num -> (-1) * (interp num)*)
    | Add(n1,n2) ->
        (interp s n1) + (interp s n2)
    | Sub(n1,n2) ->
        (interp s n1) - (interp s n2)
    | Num num -> num
    | Id n -> interp s (Num(S.find n s))
    | LetIn (x,n1,n2) -> interp (S.insert x (interp s n1) s) n2


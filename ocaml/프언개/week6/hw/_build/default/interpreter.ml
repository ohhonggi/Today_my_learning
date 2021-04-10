module F = Format

(* practice *)
let rec interp (e : Ast.ae) : int =
    match e with
    | Add(n1,n2) ->
        (interp n1) + (interp n2)
    | Sub(n1,n2) ->
        (interp n1) - (interp n2)
    | Neg num -> (-1) * (interp num)
    | Num num -> num


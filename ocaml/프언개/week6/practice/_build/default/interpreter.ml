module F = Format

(* e 가 들어올 수 있는 타입
    Num
    (ae,ae)*)
(* practice *)
let rec interp (e : Ast.ae) : int =
    match e with
    | Add(n1,n2) ->
        (interp n1) + (interp n2)
    | Sub(n1,n2) ->
        (interp n1) - (interp n2)
    | Num a -> a
(*    | Add(n1,n2) -> *)

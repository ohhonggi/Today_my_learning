  type unop = Neg
  type binop = Add | Sub | Mul | Div
  type exp =
  | Constant of int
  | Unary of unop * exp
  | Binary of exp * binop * exp

  let rec eval operation =
    match operation with
    | Constant num -> num
    | Unary (_, bi) -> - eval bi
    | Binary (e1, b, e2) ->
        let num1 = eval e1 in
        let num2 = eval e2 in
        match b with
        | Add -> num1+num2
        | Sub -> num1-num2
        | Mul -> num1*num2
        | Div -> num1/num2

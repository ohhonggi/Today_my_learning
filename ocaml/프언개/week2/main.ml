module F = Format

let _ =
  let open Arith in
  let a = eval (Binary (Constant 1, Add, Constant 3)) in (* a = 4 *)
  let _ = F.printf "a = %d\n" a in
  let b = eval (Binary (Constant 5, Add, (Unary (Neg, (Constant 3))))) in (* b = 2 *)
  let _ = F.printf "b = %d\n" b in
  let c = eval (Unary (Neg, (Binary (Constant 2, Mul, (Unary (Neg, (Constant 7))))))) in (* c = 14 *)
  let _ = F.printf "c = %d\n" c in
  let d = eval (Binary (Unary(Neg, Binary(Constant 3, Sub, Unary(Neg, Constant 5))), Add, (Unary (Neg, (Constant 3))))) in (* d = -11 *)
  F.printf "c = %d\n" d

(*함수를 저장하는 추상메모리*)
module F = Format

type t = (string * (string * Ast.expr)) list

let empty = []

let insert x param body s = (* write your code *)
    (x,(param,body))::s

let rec find x s = (* write your code *)
    match s with
    | [] -> failwith ("Free identifier " ^ x)
    | (funN,(param,body))::nextS ->
        if (funN = x) then (param,body)
        else find x nextS

  
  
let pp fmt s = 
  let rec pp_impl fmt s = 
    match s with
    | [] -> F.fprintf fmt "]"
    | (x, (p, e)) :: t -> F.fprintf fmt "(%s, (%s, %a)) %a" x p Ast.pp_e e pp_impl t
  in
  F.fprintf fmt "[ %a" pp_impl s

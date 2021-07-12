(*변수를 저장하는 추상매모리*)
module F = Format

type t = (string * int) list

let empty = []

let insert x n s = (* write your code *)
    (x,n)::s

let rec find x s = 
    match s with
    | [] ->
        failwith ("Free identifier " ^ x)
    | (n,v)::t ->
        if (n = x) then v
        else find x t

let pp fmt s = 
  let rec pp_impl fmt s = 
    match s with
    | [] -> F.fprintf fmt "]"
    | (x, n) :: t -> F.fprintf fmt "(%s, %d) %a" x n pp_impl t
  in
  F.fprintf fmt "[ %a" pp_impl s

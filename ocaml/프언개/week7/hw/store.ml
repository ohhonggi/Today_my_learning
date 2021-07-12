module L = List

type t = (string * int) list

let empty = []

let insert x n s=
    (x,n)::s

let rec find x s =
    match s with
    | [] ->
        failwith ("Free identifier " ^ x)
    | (n,v)::t ->
        if (n = x) then v
        else find x t


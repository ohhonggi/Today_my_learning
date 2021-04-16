module F = Format

type t = (string * string) list 

let empty = []

let add key value map = (* write your code *)
  (key,value)::map

let rec find key map = (* write your code *)
  match map with
  | [] -> failwith "No such key exists"
  | (k,v)::[] -> if k == key then v else failwith "No such key exists"
  | (k,v)::nextMap ->
    if k == key then v
    else find key nextMap

let rec erase key map = (* write your code *)
  match map with
  | [] -> failwith "No such key exists"
  | (k,_)::[] -> if (k == key) then [] else failwith "No such key exists"
  | beforeMap::(k,_)::nextMap ->
    if (k == key) then beforeMap::nextMap
    else erase key nextMap

let print_map fmt map = 
  let rec print_map_impl map = 
    match map with
    | [] -> ()
    | (k, v) :: t -> 
        let () = F.fprintf fmt "(%s, %s) " k v in
        print_map_impl t
  in
  let () = F.fprintf fmt "[ " in
  let () = print_map_impl map in
  F.fprintf fmt "]"

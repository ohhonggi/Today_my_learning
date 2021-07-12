module F = Format

type t = (string * string) list 

let empty = []

let rec find key map = (* write your code *)
  match map with
  | [] -> failwith "No such key exists"
  | (k,v)::nextMap ->
    if k = key then v
    else find key nextMap

let rec add key value map = (* write your code *)
    match map with
    | [] -> (key,value) :: map
    | (k,v)::t ->
        if k = key then [(key,value)]@t
        else (add key value t)  @ [(k,v)]

(*   let rec checkAdd key value map beforeMap =*)
(*       match map with*)
(*       | [] -> (key,value)::map*)
(*       | (k,_)::[] ->*)
(*         if k = key*)
(*         then beforeMap@[(key,value)]*)
(*         else List.append ((key,value)::beforeMap) map*)
(*       | (k,v)::nextMap ->*)
(*         if k = key*)
(*         then List.append beforeMap ((key,value)::nextMap)*)
(*         else checkAdd key value nextMap (List.append beforeMap ((k,v)::[]))*)
(*   in checkAdd key value map []*)

let rec erase key map = (* write your code *)
    match map with
    | [] -> failwith "No such key exists"
    |(k,v)::t ->
        if k = key then t
        else [(k,v)]@ (erase key t)

(*  let rec checkErase key map beforeMap =*)
(*      match map with*)
(*      | [] -> failwith "No such key exists"*)
(*      | (k,_)::[] ->*)
(*        if k = key*)
(*        then beforeMap*)
(*        else failwith "No such key exists"*)
(*      | (k,v)::nextMap ->*)
(*        if k = key*)
(*        then List.append beforeMap nextMap*)
(*        else checkErase key nextMap (List.append beforeMap ((k,v)::[]))*)
(*  in checkErase key map []*)

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

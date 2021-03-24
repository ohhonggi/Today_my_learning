module L = List
module F = Format
(*tail recursion하게 만들어야함.*)

let print_split_list lst =
    match lst with
    | (left,right) ->
        let _ = F.printf "([" in
        let _ = L.iter (fun x -> F.printf "%s; " x) left in
        let _ = F.printf "],[" in
        let _ = L.iter (fun x -> F.printf "%s; " x) right in
        F.printf "])\n"

let print_combine_list combineList =
    let _ = F.printf "[" in
    let _ = List.iter (fun (x,y) -> F.printf "(%s,%s);" x y) combineList in
    F.printf "]\n"

let split slist =
    let rec splitTR list left right =
        match list with
        | [] -> (L.rev left),(L.rev right)
        | (x,y)::n ->
             splitTR n (x::left) (y::right)
    in splitTR slist [] []

let combine llist rlist =
    let rec combineTR lflist rtlist result =
        match lflist with
        | [] -> List.rev result
        | left::leftnext ->
            match rtlist with
            | [] -> result
            | right::rightnext -> combineTR leftnext rightnext ((left,right)::result)
    in combineTR llist rlist []

(*let _ =*)
(*    let a = split [("a1","b1"); ("a2","b2"); ("a3","b3")] in*)
(*    let _ = print_split_list a in*)
(*    let b = L.split [("a1","b1"); ("a2","b2"); ("a3","b3")] in*)
(*    let _ = print_split_list b in*)
(*    let c = combine ["a1"; "b1"; "c1"] ["a2"; "b2"; "c2"] in*)
(*    let _ = print_combine_list c in*)
(*    let d = L.combine ["a1"; "b1"; "c1"] ["a2"; "b2"; "c2"] in*)
(*    print_combine_list d*)

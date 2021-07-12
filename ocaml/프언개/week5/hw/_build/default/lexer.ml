module F = Format

type t = 
  | Int of int
  | Var of string


type state =
  | S0
  | S1
  | S2
  | S3

let char_to_int c = (int_of_char c) - 48
let char_to_str c = Char.escaped c

(* lex : char list -> t *)
let lex chars =
    let rec lex_cv chars state num var =
    match state with
    | S0 ->
        begin
            match chars with
            | h::t ->
                begin
                    match h with
                    | '0' .. '9' -> lex_cv t S2 (num + char_to_int h) var
                    | 'a' .. 'z' -> lex_cv t S3 num (char_to_str h)
                    | '-' ->
                    begin
                        match lex_cv t S1 0 var with
                        | Int x -> Int (-1 * x)
                        | _ -> failwith "Not a valid integer or a valid variable"
                    end
                    | _ -> failwith "Not a valid integer or a valid variable"
                end
            | [] -> failwith "Not a valid integer or a valid variable"
        end
    | S1 ->
        begin
            match chars with
            | h::t ->
                begin
                    match h with
                    | '0' .. '9' -> lex_cv t S2 (num*10 + (char_to_int h)) var
                    | _ -> failwith "Not a valid integer or a valid variable"
                end
            | [] -> failwith "Not a valid integer or a valid variable"
        end
    | S2 ->
        begin
            match chars with
            | h::t ->
                begin
                    match h with
                    | '0' .. '9' -> lex_cv t S2 (num*10 + (char_to_int h)) var
                    | _ -> failwith "Not a valid integer or a valid variable"
                end
            | [] -> Int num
        end
    | S3 ->
        begin
            match chars with
            | h::t ->
                begin
                    match h with
                    | 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '\''->
                        lex_cv t S3 num (var ^ (char_to_str h))
                    | _ -> failwith "Not a valid integer or a valid variable"
                end
            | [] -> Var var
        end
    in lex_cv chars S0 0 ""

let pp fmt v = 
  match v with
  | Int i -> F.fprintf fmt "Int %d" i
  | Var x -> F.fprintf fmt "Var %s" x 

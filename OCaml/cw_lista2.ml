(* zad2 *)

let rec fib (n) = match n with
 0 -> 0
| 1 -> 1
| _ -> fib(n-2) + fib(n-1);;

let rec fibTailHelper (n, f1, f2) = match n with
0 -> f1
| 1 -> f2
| _ -> fibTailHelper(n-1, f2, f2+f1);;

let rec fibTail (n) = fibTailHelper(n, 0, 1);;

(* zad3 *)

let rec root3 (a) =
  let rec root3helper (x) =
    if abs_float(x ** 3. -. a) <= 1e-055 *. abs_float(1) then x
    else root3helper(x +. (a /. x ** 2. -. x) /. 3)
  in root3helper(if a<= 1 then a else a /. 3);;

  let root3 a =
    let rec root3Helper x =
    if abs_float(x ** 3. -. a) <= 1e-015 *. abs_float(a) then x
    else root3Helper(x +. (a /. x ** 2. -. x) /. 3.)
    in root3Helper(if a <= 1. then a else a /. 3.);;

(* zad4 *)

let pat = (-2, -1, 0, 1, 2);;
let (_, _, x, _, _) = pat;;
 
(* zad5 *)

let rec initSegment(segment, list) = match (segment, list) with
([], _) -> true
| (_, []) -> false
| _ -> if List.hd list = List.hd segment then 
initSegment(List.tl segment, List.tl list) 
else false

(* zad6 *)

let rec replaceNth(list, n, x) = match (list, n) with
([], _) -> []
| (_::tl, 0) -> x :: tl
| (hd::tl, i) -> hd :: replaceNth(tl, i-1, x);;

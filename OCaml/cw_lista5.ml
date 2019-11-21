type 'a llist = LNil | LCons of 'a * 'a llist Lazy.t;;

let rec lfrom k = LCons (k, lazy (lfrom (k+1)));


let lhd = function
LNil -> failwith "lhd"
| LCons (x, _) -> x
;;


# let ltl = function
LNil -> failwith "ltl"
| LCons (_, xf) -> xf()
;;

let rec ltake = function
(0, _) -> []
| (_, LNil) -> []
| (n, LCons(x,xf)) -> x::ltake(n-1, Lazy.force xf)
;;



(* zad1 *)

  let lrepeat k ll =
    if k < 1 then failwith "Liczba powtorzen mniejsza niz 1"
    else
    let rec helper (rpts, rest) = match (rpts, rest) with
      (_, LNil) -> LNil
      | (0, LCons(_, tl)) -> helper(k, Lazy.force tl)
      | (_, LCons(hd, _)) -> LCons(hd, lazy (helper(rpts - 1, rest)))
    in helper (k, ll)

(* zad2 *)

  let lfib = 
    let rec lfibhelper (l, n) = LCons (n, lazy(lfibhelper(n, l+n) ))
    in LCons(0, lazy(lfibhelper(0, 1)));;

(* zad3 *)

type 'a lBT = LEmpty | LNode of 'a * (unit -> 'a lBT) * (unit -> 'a lBT);;

(* let rec (@$) ll1 ll2 =
  match ll1 with
    | LNil -> ll2
    | LCons(x, lazy xf) -> LCons(x, lazy (xf @$ ll2))
;;

let rec lBreadth = function
    LEmpty -> LNil
    | LNode(n, left, right) -> LCons(n, lazy (lBreadth (left()) @$ lBreadth(right())));; *)


let rec generateTree n =
  LNode(n, (function() -> generateTree(2*n)), (function() -> generateTree(2*n+1)));;


    let lBreadth lbt = 
      let rec breadthHelp = function
          [] -> LNil
          | LEmpty::t -> breadthHelp t
          | LNode(v, l, r)::t -> LCons(v, lazy (breadthHelp(t @ [l() ; r()])))
        in breadthHelp [lbt];;
      
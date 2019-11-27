type 'a llist = LNil | LCons of 'a * 'a llist Lazy.t;;

let lhd = function
LNil -> failwith "lhd"
| LCons (x, _) -> x
;;

# let ltl = function
LNil -> failwith "ltl"
| LCons (_, xf) -> xf()
;;

let rec lfrom k = LCons (k, lazy (lfrom (k+1)));

let rec ltake = function
(0, _) -> []
| (_, LNil) -> []
| (n, LCons(x, lazy xf)) -> x::ltake(n-1, xf)
;;

(* zad1 *)

  let lrepeat k ll =
    if k < 1 then failwith "Liczba powtorzen mniejsza niz 1"
    else
    let rec helper (rpts, rest) = match (rpts, rest) with
      (_, LNil) -> LNil
      | (0, LCons(_, lazy tl)) -> helper(k, tl)
      | (_, LCons(hd, _)) -> LCons(hd, lazy (helper(rpts - 1, rest)))
    in helper (k, ll)

(* zad2 *)

  let lfib = 
    let rec lfibhelper (l, n) = LCons (n, lazy(lfibhelper(n, l+n) ))
    in LCons(0, lazy(lfibhelper(0, 1)));;

(* zad3 *)

type 'a lBT = LEmpty | LNode of 'a * (unit -> 'a lBT) * (unit -> 'a lBT);;

(* type 'a llBT = LlEmpty | LlNode of 'a * 'a llBT Lazy.t * 'a llBT Lazy.t ;; *)

let rec generateTree n =
  LNode(n, (function() -> generateTree(2*n)), (function() -> generateTree(2*n+1)));;

(* let rec generateTree2 n =
  LlNode(n, lazy (generateTree2(2*n)), lazy (generateTree2(2*n+1)));; *)


    let lBreadth lbt = 
      let rec breadthHelp = function
          [] -> LNil
          | LEmpty::t -> breadthHelp t
          | LNode(v, l, r)::t -> LCons(v, lazy (breadthHelp(t @ [l() ; r()])))
        in breadthHelp [lbt];;

        (* let llBreadth lbt = 
          let rec breadthHelp = function
              [] -> LNil
              | LlEmpty::t -> breadthHelp t
              | LlNode(v, lazy l, lazy r)::t -> LCons(v, lazy (breadthHelp(t @ [l ; r])))
            in breadthHelp [lbt];; *)
          
      
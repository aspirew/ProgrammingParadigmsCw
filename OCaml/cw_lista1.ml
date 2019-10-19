(* zad1 *)
let lista = [[1;2;3];[1;3];[5]];;

let rec flatten listOfLists =
if listOfLists=[] then []
else List.hd listOfLists @ flatten (List.tl listOfLists);;
  
flatten lista;;

(* zad2 *)

let rec count (element, lista) =
  if lista = [] then 0
  else (if List.hd lista = element then 1 else 0) + count(element, List.tl lista);;

count(1,[1;2;3;1]);;

(* zad3 *)

let rec replicate (element, quantity) =
  if quantity < 0 then failwith "Ilosc mniejsza niz 0"
  else if quantity = 0 then []
  else element :: replicate(element, quantity - 1);;

replicate("!",3);;

(* zad4 *)

let rec sqrList lista =
  if lista = [] then []
  else List.hd lista * List.hd lista :: sqrList(List.tl lista);;

  sqrList [1;2;3];;

  (* zad5 *)

let palindrome lista =
lista = List.rev lista;;

palindrome ['a';'b';'b';'a'];;

(* zad6 *)

let rec listLength lista =
  if lista = [] then 0
  else 1 + listLength (List.tl lista);;

  listLength ['a';'a';'a'];;
let rec sumProd xs = 
  match xs with
  h::t -> let (s, p) = sumProd t
  in (h+s,h*p)
  | [] -> (0,1);;

  let sumProd xs = 
    List.fold_left (fun (s, p) h -> (s + h, p * h)) (0, 1) xs;; 


let isBigger (element1, element2) = element1 > element2;;

let insertionsort compare list = 
  let rec innerSort compare list resultList =
    match (list, resultList) with 
    ([], _) -> resultList
    | (list, []) -> innerSort compare List.tl list List.hd list::[]
    | (listUnordered, listOrdered) ->
      let rec checker element resultList =
        if resultList = [] then element::[]
        else if compare(element, List.head resultList) then
        List.hd list::checker element List.tl resultList
        else element::resultList
      in innerSort compare List.tl list checker List.hd listUnordered listOrdered
    in compare List.tl list [];;
let rec sumProd xs = 
  match xs with
  h::t -> let (s, p) = sumProd t
  in (h+s,h*p)
  | [] -> (0,1);;

  let sumProd xs = 
    List.fold_left (fun (s, p) h -> (s + h, p * h)) (0, 1) xs;; 
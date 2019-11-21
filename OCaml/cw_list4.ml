(* zad3 *)

type 'a bt = Empty | Node of 'a * 'a bt * 'a bt;;

let t = Node(1, 
          Node(2, Node(4, Empty, Empty), 
            Empty),
              Node(3, 
                Node(5, Empty, 
                  Node(6, Empty, Empty)), 
                    Empty));;
                  
let breadthBT tt = 
let rec breadthHelp queue = match queue with
    [] -> []
    | Empty::t -> breadthHelp t
    | Node(v, l, r)::t -> v::breadthHelp(t@[l;r])
  in breadthHelp [tt];;


  (* zad5 *)

  type 'a graph = Graph of ('a -> 'a list);;

  let g = Graph(function 
  0 -> [3]
  | 1 -> [2;0;4]
  | 2 -> [1]
  | 3 -> []
  | 4 -> [0;2]
  | n -> failwith ("Graph g: node "^string_of_int n^" doesnt exist")  
  );;
  

  let depthSearch (Graph succ) startElement =
    let rec dSHelp visited stack =
      if stack = [] then []
      else if doesContain (visited, List.hd stack) then dSHelp visited (List.tl stack)
      else List.hd stack::(dSHelp((List.hd stack)::visited)(succ(List.hd stack)@(List.tl stack)))
  in dSHelp [] [startElement];;


  let depthSearch (Graph succ) startElement =
    let rec dSHelp visited stack = match stack with
    [] -> []
    | h::t ->
      if doesContain (visited, h) then dSHelp visited t
      else h::(dSHelp(h::visited)(succ h @ t))
  in dSHelp [] [startElement];;


  let depthSearch (Graph succ) startNode =
    let rec dSHelp visited stack = match visited with
    [] -> []
    | h :: t -> if List.mem h visited then dSHelp visited t
    else h :: dSHelp (h :: visited) (succ h @ t)
    in dSHelp [] [startNode];;

  let rec doesContain (lista, element) =
    if lista = [] then false
    else if List.hd lista = element then true
    else doesContain (List.tl lista, element);;
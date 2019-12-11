module type QUEUE_FUN =
sig
  type 'a t
  exception Empty of string
  val empty: unit -> 'a t
  val enqueue: 'a * 'a t -> 'a t
  val dequeue: 'a t -> 'a t
  val first: 'a t -> 'a
  val isEmpty: 'a t -> bool
end;;

(* a *)

module Queue : QUEUE_FUN =
struct
  type 'a t = 'a list
  exception Empty of string

  let empty() = []
  let enqueue(e, q) = q @ [e]

  let rec dequeue = function
  [] -> []
  | h::t -> t

  let rec first = function
  [] -> raise (Empty "module Queue: first")
  | h::t -> h
  
  let isEmpty q = q = []

end;;

let q = Queue.(enqueue(3, enqueue(2, enqueue(1,empty()))));;
let q = let open Queue in enqueue(3, enqueue(2, enqueue(1,empty())));;
(* val q : int Queue.t = <abstr> *)
Queue.first q;;
(* int = 1 *)
Queue.dequeue q;;
(* int Queue.t = <abstr> *)

(* b *)


module PairOfListsQueue : QUEUE_FUN =
struct
  type 'a t = 'a list * 'a list

  exception Empty of string

  let empty () = ([], [])

  let normalize = function 
  ([], endOfQueue) -> (List.rev endOfQueue, [])
  | normalQueue -> normalQueue

  let enqueue (e, q) =
    normalize(fst q, e :: snd q)

  let rec dequeue = function
  ([], _) -> ([], [])
  | (h::t, endOfQueue) -> normalize(t, endOfQueue)

  let first queue =
    match fst queue with 
    [] -> raise (Empty "module PairOfListsQueue: first")
    | h::t -> h

  let isEmpty q = fst q = []

 end;;

 let q = PairOfListsQueue.(enqueue(3,enqueue(2,enqueue(1, empty()))));;
 PairOfListsQueue.first q;;


 (* zad2 *)

 let (%) x y = ((x % y) + y) % y;;
  
 module type QUEUE_MUT=
 sig
  type 'a t
    (* The type of queues containing elements of type ['a]. *)
  exception Empty of string
    (* Raised when [first q] is applied to an empty queue [q]. *)
  exception Full of string
    (* Raised when [enqueue(x,q)] is applied to a full queue [q]. *)
  val empty: int -> 'a t
    (* [empty n] returns a new queue of length [n], initially empty. *)
  val enqueue: 'a * 'a t -> unit
    (* [enqueue (x,q)] adds the element [x] at the end of a queue [q]. *)
  val dequeue: 'a t -> unit
    (* [dequeue q] removes the first element in queue [q] *)
  val first: 'a t -> 'a
    (* [first q] returns the first element in queue [q] without removing  it from the queue, or raises [Empty] if the queue is empty.*)
  val isEmpty: 'a t -> bool
    (* [isEmpty q] returns [true] if queue [q] is empty, otherwisereturns [false]. *)
  val isFull: 'a t -> bool
    (* [isFull q] returns [true] if queue [q] is full, otherwise returns [false]. *)
  end;;

module CyclicArrayQueue : QUEUE_MUT =
  struct
    type 'a t = { a: 'a option array; mutable f: int; mutable r: int}
    exception Empty of string
    exception Full of string

    let empty n =
      {a = Array.make (n+1) None; f = 0; r = 0}

    let isEmpty q =
      q.r = q.f

    let isFull q =
      q.r - q.f = -1 || q.r - q.f = Array.length q.a - 1
      
    let enqueue (element, q) =
      if (isFull q) then raise (Full "module CyclicArrayQueue: enqueue")
      else
        q.a.(q.r) <- Some element;
        if q.r = Array.length q.a -1 then q.r <- 0
        else q.r <- q.r + 1

    let dequeue q =
      if (isEmpty q) then ()
      else 
        if q.f = Array.length q.a - 1 then q.f <- 0
        else q.f <- q.f + 1
    
    let first q =
      if (isEmpty q) then raise (Empty "module CyclicArrayQueue: first")
      else match (q.a.(q.f)) with
      Some value -> value
      | None -> failwith "module CyclicArrayQueue: first (implementation error!!!)"

    end;;

    let q = CyclicArrayQueue.empty 3;;
    (* val q : '_weak1 CyclicArrayQueue.t = <abstr>.e *)
    CyclicArrayQueue.enqueue(1, q);;
    CyclicArrayQueue.enqueue(2, q);;
    CyclicArrayQueue.enqueue(3, q);;
    CyclicArrayQueue.enqueue(4, q);;


def initSegment [A](xs: List[A], ys:List[A]):Boolean =
  if (xs == ys || ys == Nil) true else
    if(xs.length > ys.length) false else initSegmentHelper(xs, ys)

  def initSegmentHelper[A](xs: List[A], ys: List[A]): Boolean =
    if(xs == Nil) true else
      if(xs.head == ys.head) initSegmentHelper(xs.tail, ys.tail) else false

//initSegment(List(), List(1,2,3))

def initSegment [A](xs: List[A], ys:List[A]):Boolean =
  if(xs.length > ys.length) false else
  (xs, ys) match {
    case(Nil, _) => true
    case(_, Nil) => false
    case _ => if(xs.head == ys.head) initSegment(xs.tail, ys.tail) else false
  }
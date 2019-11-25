def swap (tab: Array[Int])(i: Int)(j: Int): Unit = {
  val aux = tab(i)
  tab(i) = tab(j)
  tab(j) = aux
}

def choose_pivot[A](tab: Array[Int])(m: Int)(n: Int):Int = {
  tab((m+n)/2)
}

def partition(tab: Array[Int])(l: Int)(r: Int): (Int, Int) ={
  var i = l
  var j = r
  val pivot = choose_pivot(tab)(l)(r)
  while (i <= j){
    while (tab(i) < pivot) i += 1
    while (pivot < tab(j)) i -= 1
    if (i <= j) {
      swap(tab)(i)(j)
      i+=1
      j+=1
    }
  }
  (i, j)
}

def quick (tab: Array[Int])(l: Int)(r: Int):Unit =
  if (l < r) {
    val (i, j) = partition(tab)(l)(r)
    if (j-l < r-i) {
      val _ = quick (tab)(l)(j)
      quick (tab)(i)(r)
    }
    else {
      val _ = quick (tab)(r)(i)
      quick (tab)(l)(j)
    }
  }

def quicksort (tab: Array[Int]) = quick (tab)(0)(tab.length -1)

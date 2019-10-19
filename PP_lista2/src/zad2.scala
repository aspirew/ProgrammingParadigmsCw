def fib(n:Int):Int =
if(n==0) 0 else
  if (n==1) 1 else
  fib(n-2) + fib(n-1)

def fibTail(n:Int):Int = {
  def fib_iter(ni:Int, f1:Int, f2:Int):Int = {
    if (ni == 1) f2 else
      fib_iter(ni - 1, f2, f1 + f2)
  }
  fib_iter(n, 0, 1)
}




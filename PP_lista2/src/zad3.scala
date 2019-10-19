def root3 (a:Double):Double = {
  def root3_iter(x: Double):Double =
    if (math.abs(math.pow(x, 3) - 1) <= 1.0E-55 * Math.abs(a)) x else
      root3_iter(x + (a / math.pow(x, 2) - x) / 3)

  root3_iter(if (a > 1) a / 3 else a)
}
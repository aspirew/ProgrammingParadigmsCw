def replicate[A](element:A, quantity:Int):List[A] =
if (quantity < 0) throw new Exception("Ujemna ilość elementów") else
if (quantity == 0) Nil else
  element :: replicate(element, quantity-1)

type ChurchNumeral[T] = (T => T, T) => T

def cn0[T](f:T=>T, x:T):T = x
def cn1[T](f:T=>T, x:T):T = f(x)
def cn2[T](f:T=>T, x:T):T = f(f(x))
def cn3[T](f:T=>T, x:T):T = f(f(f(x)))

def successor[T] = (n:ChurchNumeral[T]) => (f:T=>T, x:T) => f(n(f, x))
def plus[T] = (m:ChurchNumeral[T], n:ChurchNumeral[T]) => (f:T=>T, x:T) => m(f, n(f, x))

val increment = (i:Int) => i + 1

def convertToInt(churchNumeral:ChurchNumeral[Int]):Int = {
  churchNumeral(increment, 5)
}

cn3(increment, cn2(increment, 0))

convertToInt(cn0)
convertToInt(cn1)
convertToInt(cn2)

def derivedC3[T]:ChurchNumeral[T] = successor(cn2)
convertToInt(cn3)
convertToInt(derivedC3)

def cn5[T]:ChurchNumeral[T] = plus(cn3, cn3)
convertToInt(cn5)


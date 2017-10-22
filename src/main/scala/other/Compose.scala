package other

/**
  * Created by abulseed on 10/22/2017.
  */
object Compose {
  def compose(f: Int => Int, g: Int => Int) = {
    f compose (g)
  }

  def h = compose({ x: Int => x * x},
    { x: Int => x + 1 })
}

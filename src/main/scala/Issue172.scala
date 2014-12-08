import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule

object Issue172 extends App {

  case class A(value: BigDecimal) extends AnyVal

  case class B(values: List[A])

  new ObjectMapper().registerModule(DefaultScalaModule).writeValueAsString(B(List(A(42), A(199))))

}
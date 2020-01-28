import scala.swing._
import scala.swing.event._

object TextFields extends SimpleSwingApplication {
  override def top: Frame = new MainFrame {
    title = "TextFields"
    preferredSize = new Dimension(250, 100)
    resizable = false
    val inText = new TextField(10)
    val outText = new TextField(10) {editable = false}
    val inTextLabel = new Label("input")
    val outTextLabel = new Label("output")
    contents = new FlowPanel(){
      contents += inTextLabel
      contents += inText
      contents += outTextLabel
      contents += outText
      border = Swing.EmptyBorder(30,30,30,30)
    }
    listenTo(inText)
    reactions += {
      case EditDone(_) =>
        outText.text = inText.text
        inText.text = ""
    }
  }
}

import java.awt.*
import java.awt.image.BufferedImage
import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.concurrent.TimeUnit
import javax.imageio.ImageIO



fun main(args: Array<String>) {
    //currentDateTime()
    //captureScreen()

    while (true) {
        TimeUnit.SECONDS.sleep(2L)
        println(currentDateTime())
    }

}

// https://www.programiz.com/kotlin-programming/examples/current-date-time
private fun currentDateTime(): String {
    val current = LocalDateTime.now()
    val dtf = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")
    return current.format(dtf)
}

/**
 * https://stackoverflow.com/a/58348273/9818338
 */
private fun captureScreen() {
    println("Capturing Screen")
    val graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().defaultScreenDevice
    val screenWidth = graphicsDevice.displayMode.width
    val screenHeight = graphicsDevice.displayMode.height

    val robot = Robot(graphicsDevice)
    val rect = Rectangle(Toolkit.getDefaultToolkit().screenSize)

    val multiResolutionScreenshot = robot.createMultiResolutionScreenCapture(rect)
    val screenshot = multiResolutionScreenshot.getResolutionVariant(
        screenWidth.toDouble(), screenHeight.toDouble()
    )

    ImageIO.write(screenshot as BufferedImage, "png", File("./screenshot.png"))
}

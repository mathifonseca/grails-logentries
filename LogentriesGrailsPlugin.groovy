import org.apache.log4j.Logger
import com.logentries.log4j.LogentriesAppender

class LogentriesGrailsPlugin {

    def version = '1.3.0'
    def grailsVersion = "2.3 > *"
    def title = "Logentries Plugin"
    def author = "Mathias Fonseca"
    def authorEmail = "mathifonseca@gmail.com"
    def description = 'Provides integration with Logentries (https://logentries.com/)'
    def documentation = "http://grails.org/plugin/logentries"
    def license = "APACHE"
    def issueManagement = [ system: "GITHUB", url: "https://github.com/mathifonseca/grails-logentries/issues" ]
    def scm = [ url: "https://github.com/mathifonseca/grails-logentries" ]

    def doWithApplicationContext = { ctx ->

        def conf = application.config.logentries
        if (!conf.enabled) {
            return
        }

        def name = conf.appender.name
        def layout = conf.appender.layout
        def token = conf.appender.token
        def threshold = conf.appender.threshold

        Logger.rootLogger.addAppender(new LogentriesAppender(
            name: name, layout: layout, token: token, threshold: threshold))
    }
}

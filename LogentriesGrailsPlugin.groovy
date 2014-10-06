import org.apache.log4j.Logger
import com.logentries.log4j.LogentriesAppender

class LogentriesGrailsPlugin {

    def version = "0.0.1"
    def grailsVersion = "2.3 > *"
    def title = "Logentries Plugin"
    def author = "Mathias Fonseca"
    def authorEmail = "mathifonseca@gmail.com"
    def description = '''\
This plugin provides integration with Logentries (https://logentries.com/)
'''
    def documentation = "http://grails.org/plugin/logentries"
    def license = "APACHE"
    def issueManagement = [ system: "GITHUB", url: "https://github.com/mathifonseca/grails-logentries/issues" ]
    def scm = [ url: "https://github.com/mathifonseca/grails-logentries" ]

    def doWithApplicationContext = { ctx ->
        if (application.config.logentries.enabled) {
            def name = application.config.logentries.appender.name
            def layout = application.config.logentries.appender.layout
            def token = application.config.logentries.appender.token
            def threshold = application.config.logentries.appender.threshold
            def appender = new LogentriesAppender(name: name, layout: layout, token: token, threshold: threshold)
            Logger.rootLogger.addAppender(appender)
        }
    }

}
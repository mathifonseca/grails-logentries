Grails Logentries Integration Plugin
=================

[![Build Status](https://travis-ci.org/mathifonseca/grails-logentries.svg?branch=master)](https://travis-ci.org/mathifonseca/grails-logentries)

With this plugin, you just need to add this section to your Config.groovy

```
logentries {
    enabled = true
    appender {
        name    = 'le'
        layout  = pattern(conversionPattern: '%d{yyyy-MM-dd HH:mm:ss} %-5p [%-18c{1}] %m%n')
        token   = '<YOUR_TOKEN>'
    }
}
```

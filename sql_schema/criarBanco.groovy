import groovy.sql.Sql
import org.jooq.*
import org.jooq.impl.DSL

@Grab(group='org.jooq', module='jooq', version='3.10.4')
import org.jooq.impl.DSL

@GrabConfig(systemClassLoader=true)
@Grab(group='com.h2database', module='h2', version='1.4.196')
def sql = Sql.newInstance('jdbc:h2:./jooq-test', 'root', 'admin', 'org.h2.Driver')

def initDatabaseScriptText = new File('./banco_teste.sql').text

def separator = ";"

initDatabaseScriptText.split(separator).each {
    def command = it.trim()
    if (!command.equals("")) {
        sql.execute(command)
    }
}

package com.jooq;

import static org.jooq.h2.generated.Tables.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.function.Consumer;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.jupiter.api.Test;

public class TesteJooq {

	@Test
	public void testeInicial() throws SQLException {
		System.out.println("jOOQ + Java 8");
		System.out.println("https://www.jooq.org/doc/3.5/manual/getting-started/jooq-and-java-8/");

		System.out.println();
		System.out.println("Listando registros da tabela de livros:");
		Connection conn = getConnection();
		DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
		create. //
				select().from(BOOK) //
				.fetch() //
				.forEach(System.out::println);
	}

	public Connection getConnection() throws SQLException {
		String userName = "root";
		String password = "admin";
		String url = "jdbc:h2:./sql_schema/jooq-test";

		Connection conn = DriverManager.getConnection(url, userName, password);
		return conn;
	}

}

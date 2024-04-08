package com.patrones.asistencia_vehicular;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.patrones.asistencia_vehicular.services.AdminService;

@SpringBootTest
class MainApplicationTests {
	@Autowired
    private AdminService adminService;
	@Test
	void contextLoads() {
        adminService.test("hola mundo");
	}
}
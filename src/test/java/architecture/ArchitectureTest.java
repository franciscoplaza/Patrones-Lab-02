package architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.Test;

public class ArchitectureTest {

    private final JavaClasses classes = new ClassFileImporter().importPackages("dao", "service", "ui");

    //1. y 3.
    @Test
    void ui_accede_service() {
        ArchRuleDefinition.classes()
                .that().resideInAPackage("..ui..")
                .should().onlyAccessClassesThat()
                .resideInAnyPackage("..service..", "..ui..", "java..")
                .because("UI solo puede acceder a Service")
                .check(classes);
    }


    //2
    @Test
    void service_accede_dao() {
        ArchRuleDefinition.classes()
                .that().resideInAPackage("..service..")
                .should().onlyAccessClassesThat()
                .resideInAnyPackage("..dao..", "..service..", "java..")
                .because("Service solo puede acceder a DAO")
                .check(classes);
    }


    @Test
    void dao_accede_nada(){
        ArchRuleDefinition.classes()
                .that().resideInAPackage("..dao..")
                .should().onlyAccessClassesThat()
                .resideInAnyPackage("..dao..", "java..")
                .because("Dao no puede acceder a nada")
                .check(classes);
    }


    //4
    @Test
    void ui_sin_dependencias_cruzadas() {
        ArchRuleDefinition.noClasses()
                .that().resideInAPackage("..ui..")
                .should().dependOnClassesThat().resideInAnyPackage("..ui..")
                .because("Las clases UI no deben depender entre sí")
                .check(classes);
    }

    @Test
    void service_sin_dependencias_cruzadas() {
        ArchRuleDefinition.noClasses()
                .that().resideInAPackage("..service..")
                .should().dependOnClassesThat().resideInAnyPackage("..service..")
                .because("Las clases Service no deben depender entre sí")
                .check(classes);
    }

    @Test
    void dao_sin_dependencias_cruzadas() {
        ArchRuleDefinition.noClasses()
                .that().resideInAPackage("..dao..")
                .should().dependOnClassesThat().resideInAnyPackage("..dao..")
                .because("Las clases DAO no deben depender entre sí")
                .check(classes);
    }

}

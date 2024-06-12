package com.ac2.facens.api.services;

import com.ac2.facens.model.StudentModel;
import com.ac2.facens.model.SubjectModel;
import com.ac2.facens.utils.list.ListaSE;
import com.ac2.facens.utils.tree.BinaryTree;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Component
public class StudentService {
    
    @Autowired
    private BinaryTree binaryTree;
    private StudentModel subjectList;

    public void addStudent(String name, LocalDate birthday) {
        StudentModel student = new StudentModel(name, birthday);
        binaryTree.insert(student);
    }

    public void addStudent(StudentModel student) {
        binaryTree.insert(student);
    }

    public Optional<StudentModel> getStudent(long id) {
        return binaryTree.search(id);
    }

    public List<StudentModel> getAllStudents(){
        return binaryTree.getAllStudents();
    }

    public void deleteStudent(long id) {
        binaryTree.delete(id);
    }

    //TODO: Encontrar uma solução de adicionar pelo id e não pelo objeto. Até lá os métodos de adição ficarão desabilitados

   // public void addSubject(long studentId, long subjectId) {
        //Optional<StudentModel> student = binaryTree.search(studentId);
       // student.ifPresent(studentModel -> studentModel.getSubjects().insert(subjectId));
  //  }

    public void removeSubject(long studentId, long subjectId) {
        Optional<StudentModel> student = binaryTree.search(studentId);
        student.ifPresent(studentModel -> studentModel.getSubjects().remove(subjectId));
    }


    @PostConstruct
    public void init() {
        try {
            List<StudentModel> students = Arrays.asList(
                    new StudentModel("Rafael Rocha Leite", LocalDate.parse("2003-12-26")),
                    new StudentModel("Pedro Rovira", LocalDate.parse("2004-02-02")),
                    new StudentModel("Andre Siqueira", LocalDate.parse("2001-02-23")),
                    new StudentModel("Daniel Morais", LocalDate.parse("2005-06-09")),
                    new StudentModel("Lucas Almeida", LocalDate.parse("2002-07-19")),
                    new StudentModel("Mariana Santos", LocalDate.parse("2003-11-03")),
                    new StudentModel("Carla Oliveira", LocalDate.parse("2001-03-22")),
                    new StudentModel("Fernanda Costa", LocalDate.parse("2004-08-15")),
                    new StudentModel("Gabriel Souza", LocalDate.parse("2005-05-30")),
                    new StudentModel("Ana Paula Lima", LocalDate.parse("2002-09-07")),
                    new StudentModel("Eduardo Ferreira", LocalDate.parse("2003-10-10")),
                    new StudentModel("Juliana Cardoso", LocalDate.parse("2004-12-24")),
                    new StudentModel("Rodrigo Azevedo", LocalDate.parse("2005-04-12")),
                    new StudentModel("Paula Ribeiro", LocalDate.parse("2001-11-18")),
                    new StudentModel("Marcelo Duarte", LocalDate.parse("2002-01-29")),
                    new StudentModel("Beatriz Pires", LocalDate.parse("2003-05-14")),
                    new StudentModel("Carlos Mendes", LocalDate.parse("2004-06-25")),
                    new StudentModel("Patricia Nunes", LocalDate.parse("2001-12-05")),
                    new StudentModel("Sergio Batista", LocalDate.parse("2002-03-17")),
                    new StudentModel("Joana Monteiro", LocalDate.parse("2003-08-21")),
                    new StudentModel("Thiago Cunha", LocalDate.parse("2004-09-19")),
                    new StudentModel("Monica Farias", LocalDate.parse("2005-07-11")),
                    new StudentModel("Renato Lima", LocalDate.parse("2001-02-04")),
                    new StudentModel("Simone Martins", LocalDate.parse("2002-10-15")),
                    new StudentModel("Fabio Antunes", LocalDate.parse("2003-11-26")),
                    new StudentModel("Claudia Teixeira", LocalDate.parse("2004-01-08")),
                    new StudentModel("Jorge Carvalho", LocalDate.parse("2005-03-19")),
                    new StudentModel("Elaine Rodrigues", LocalDate.parse("2001-06-21")),
                    new StudentModel("Ricardo Campos", LocalDate.parse("2002-08-11")),
                    new StudentModel("Vanessa Souza", LocalDate.parse("2003-09-30"))
            );

            List<SubjectModel> team1 = Arrays.asList(
                    new SubjectModel("Programação Orientada a Objeto"),
                    new SubjectModel("Design Web"),
                    new SubjectModel("Modelagem Matemática"),
                    new SubjectModel("Engenharia de Software"),
                    new SubjectModel("Design Thinking"),
                    new SubjectModel("Inteligência Artificial"));

            List<SubjectModel> team2 = Arrays.asList(
                    new SubjectModel("UPX"),
                    new SubjectModel("Banco de dados"),
                    new SubjectModel("Programação Aplicada"),
                    new SubjectModel("Arquitetura de Software"),
                    new SubjectModel("Segurança da Informação"),
                    new SubjectModel("Sistemas Operacionais"));

            for (StudentModel student : students) {
                addStudent(student);
                if (student.getId() % 2 == 0) {
                    student.setSubjects(team1);
                }else{
                    student.setSubjects(team2);
                }
            }
            binaryTree.reorganize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

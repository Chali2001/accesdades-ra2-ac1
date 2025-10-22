package accesdades.ra2.ac1.accesdades_ra2_ac1.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import accesdades.ra2.ac1.accesdades_ra2_ac1.model.Student;

@Repository
public class StudentRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final class StudentRowMapper implements RowMapper<Student>{
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException{

            Student student = new Student();
            student.setId(rs.getLong("id"));
            student.setAge(rs.getInt("age"));
            student.setNom(rs.getString("nom"));
            student.setCognom(rs.getString("cognom"));
            student.setCicle(rs.getString("cicle"));
            student.setAny(rs.getInt("anyo"));
            return student;

        }
    }

    public List<Student> findAll(){
        String sql = "select * from students";
        return jdbcTemplate.query(sql, new StudentRowMapper());

    }

    public int save(){
        String sql = "insert into Students (nom, age, cicle) values(?, ?, ?)";
        return jdbcTemplate.update(sql, "Chali", 24, "DAM2B");
        
        
    }

    public int insert10Students() {
        final String sql = "INSERT INTO students (nom, cognom, age, cicle, anyo) VALUES (?,?,?,?,?)";

        List<Object[]> batchArgs = List.of(
            new Object[]{"Ana",   "López",   19, "DAM1A", 2025},
            new Object[]{"Bruno", "Santos",  20, "DAM1B", 2025},
            new Object[]{"Carla", "Mora",    21, "DAM2A", 2025},
            new Object[]{"David", "Iglesias",22, "DAM2B", 2025},
            new Object[]{"Eva",   "Roca",    23, "ASIX1A",2025},
            new Object[]{"Fabio", "Nadal",   24, "ASIX1B",2025},
            new Object[]{"Gema",  "Ríos",    20, "ASIX2A",2025},
            new Object[]{"Hugo",  "Paz",     21, "ASIX2B",2025},
            new Object[]{"Irene", "Serra",   22, "DAW1A", 2025},
            new Object[]{"Jordi", "Vidal",   23, "DAW2A", 2025}
        );
        int[] res = jdbcTemplate.batchUpdate(sql, batchArgs);
        return Arrays.stream(res).sum();
}


}

package exemplo.com.br.listaNegativa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ListaNegativaRepository {

    @Autowired
    private EntityManager entityManager;

    public String chamarProcedure(String jsonInput) {
        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery("ProcessaUsuarioJson")
                .registerStoredProcedureParameter(1, String.class, jakarta.persistence.ParameterMode.IN)
                .registerStoredProcedureParameter(2, String.class, jakarta.persistence.ParameterMode.OUT);

        query.setParameter(1, jsonInput);
        query.execute();

        return query
                .getOutputParameterValue(2)
                .toString();
    }
}

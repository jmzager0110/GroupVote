package com.liftoff.soloproject.data;

import com.liftoff.soloproject.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface EventRepository extends CrudRepository<Event, Integer> {
}

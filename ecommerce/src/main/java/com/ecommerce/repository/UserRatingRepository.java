package com.ecommerce.repository;

import com.ecommerce.domain.UserRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRatingRepository extends JpaRepository<UserRating, Long> {

}

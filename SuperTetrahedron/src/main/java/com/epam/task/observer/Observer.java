package com.epam.task.observer;

import com.epam.task.entity.Tetrahedron;

public interface Observer {
  void update(Tetrahedron tetrahedron);
}

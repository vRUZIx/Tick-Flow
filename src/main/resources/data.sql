INSERT INTO tasks (id, title, description, due_date, created_at, status, priority, tag)
VALUES
    (
        '550e8400-e29b-41d4-a716-446655440000',
        'Finish Java Project',
        'Complete backend APIs for TickFlow application',
        '2026-05-20',
        CURRENT_DATE,
        'InProgress',
        'HIGH',
        'WORK'
    ),

    (
        '550e8400-e29b-41d4-a716-446655440001',
        'Study Spring Security',
        'Learn JWT and role-based authentication',
        '2026-05-18',
        CURRENT_DATE,
        'TODO',
        'HIGH',
        'STUDY'
    ),

    (
        '550e8400-e29b-41d4-a716-446655440002',
        'Buy Groceries',
        'Milk, eggs, bread and coffee',
        '2026-05-15',
        CURRENT_DATE,
        'Done',
        'LOW',
        'SHOPPING'
    ),

    (
        '550e8400-e29b-41d4-a716-446655440003',
        'Gym Training',
        'Leg day workout session',
        '2026-05-17',
        CURRENT_DATE,
        'TODO',
        'MEDIUM',
        'HEALTH'
    ),

    (
        '550e8400-e29b-41d4-a716-446655440004',
        'Team Meeting',
        'Discuss project deadlines and tasks',
        '2026-05-16',
        CURRENT_DATE,
        'InProgress',
        'MEDIUM',
        'MEETING'
    ),

    (
        '550e8400-e29b-41d4-a716-446655440005',
        'Fix Production Bug',
        'Resolve authentication issue in login flow',
        '2026-05-14',
        CURRENT_DATE,
        'TODO',
        'HIGH',
        'URGENT'
    );
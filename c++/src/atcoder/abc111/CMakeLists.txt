add_library(atcoder_abc111_a_shared SHARED 
    ./a.cpp
)
target_include_directories(atcoder_abc111_a_shared PUBLIC 
    ${CMAKE_CURRENT_SOURCE_DIR}
)

add_executable(atcoder_abc111_a
    ./a.cpp
)

add_library(atcoder_abc111_b_shared SHARED 
    ./b.cpp
)
target_include_directories(atcoder_abc111_b_shared PUBLIC 
    ${CMAKE_CURRENT_SOURCE_DIR}
)

add_executable(atcoder_abc111_b
    ./b.cpp
)

add_library(atcoder_abc111_c_shared SHARED 
    ./c.cpp
)
target_include_directories(atcoder_abc111_c_shared PUBLIC 
    ${CMAKE_CURRENT_SOURCE_DIR}
)

add_executable(atcoder_abc111_c
    ./c.cpp
)

add_library(atcoder_abc111_d_shared SHARED 
    ./d.cpp
)
target_include_directories(atcoder_abc111_d_shared PUBLIC 
    ${CMAKE_CURRENT_SOURCE_DIR}
)

add_executable(atcoder_abc111_d
    ./d.cpp
)

# Test
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/test)
enable_testing()
include_directories(
    GoogleTest
)

add_executable(atcoder_abc111_a_test 
    a_test.cpp
)

target_link_libraries(atcoder_abc111_a_test PRIVATE
    GTest::GTest
    GTest::Main
    atcoder_abc111_a_shared
)

add_executable(atcoder_abc111_b_test 
    b_test.cpp
)

target_link_libraries(atcoder_abc111_b_test PRIVATE
    GTest::GTest
    GTest::Main
    atcoder_abc111_b_shared
)

add_executable(atcoder_abc111_c_test 
    c_test.cpp
)

target_link_libraries(atcoder_abc111_c_test PRIVATE
    GTest::GTest
    GTest::Main
    atcoder_abc111_c_shared
)

gtest_discover_tests(
    atcoder_abc111_a_test
    atcoder_abc111_b_test
    atcoder_abc111_c_test
)
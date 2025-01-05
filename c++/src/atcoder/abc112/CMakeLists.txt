add_library(atcoder_abc112_shared SHARED 
    ./a.cpp
)
target_include_directories(atcoder_abc112_shared PUBLIC 
    ${CMAKE_CURRENT_SOURCE_DIR}
)

add_executable(atcoder_abc112
    ./a.cpp
)

# Test
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/test)
enable_testing()
include_directories(
    GoogleTest
)

add_executable(atcoder_abc112_test 
    a_test.cpp
)

target_link_libraries(atcoder_abc112_test PRIVATE
    GTest::GTest
    GTest::Main
    atcoder_abc112_shared
)

gtest_discover_tests(atcoder_abc112_test)
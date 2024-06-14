(ns nine-clj-example.core
  (:gen-class)
  (:require
    [nine-clj.core :as n]
  )
)

(defn test-setup []
  (let
    [
      gl (n/new-gl)
      skin-shader (n/load-shader gl "res/shaders/diffuse_skin_vertex.glsl" "res/shaders/diffuse_fragment.glsl")
      diffuse-shader (n/load-shader gl "res/shaders/diffuse_vertex.glsl" "res/shaders/diffuse_fragment.glsl")
      graphics (n/load-graphics gl diffuse-shader skin-shader)
      model (n/load-animated-model graphics "res/models/Knight/LongSword_Idle.dae")
      anim (n/load-anim graphics "res/models/Knight/LongSword_Idle.dae")
      scene (n/load-model graphics "res/models/Scenes/Mountains.dae")
    ]
    { :model model :anim anim :scene scene }
  )
)

(defn test-loop [state]
  (n/projection (n/perspective (n/width) (n/height) (n/radians 60) 0.01 100))
  (n/camera (n/orbital-camera (n/vec3f 0 2 0) (n/vec3f 0 0 0) 5))
  (n/model (state :scene))
  (n/animated-model (state :model) (n/animate (state :anim) (n/get-time)))
  state
)

(defn -main [& args]
  (n/window 1000 800 test-setup test-loop {})
)
import { useState } from "react"


function App() {

  const [count, setCount] = useState(0);

  return (
    <>
      <div className='text-center text-4xl text-cyan-500'>
        hello
      </div>

      <div className="count text-center p-2 grid grid-rows-6" >
        <h2 className="text-xl text-fuchsia-600">Count</h2>
        {count}
        <button className="bg-slate-500 w-1/3 justify-center"
          onClick={() => setCount(count + 1)}>Plus</button>
      </div>

      <div className=" text-center">
        <h1 className="text-4xl">Busca Chamba</h1>
      </div>
    </>
  )
}

export default App

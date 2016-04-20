(function(){
    'use strict';

    var isBrowserSupported = !CKEDITOR.env.ie || CKEDITOR.env.version > 8;

    CKEDITOR.plugins.add('prismhighlight', {
        afterInit: function(editor){
            var path = this.path;

            var prismHighlighter = new CKEDITOR.plugins.codesnippet.highlighter({
                languages: {
                    apacheconf: 'Apache Conf',
                    aspnet: 'ASP.NET',
                    bash: 'Bash',
                    c: 'C',
                    cpp: 'C++',
                    csharp: 'C#',
                    coffeescript: 'CoffeeScript',
                    css: 'CSS',
                    fsharp: 'F#',
                    git: 'Git',
                    go: 'GO',
                    groovy: 'Groovy',
                    haskell: 'Haskell',
                    markup: 'Markup (HTML, XML)',
                    http: 'HTTP',
                    ini: 'INI',
                    java: 'Java',
                    javascript: 'JavaScript',
                    objectivec: 'Objective C',
                    php: 'PHP',
                    python: 'Python',
                    ruby: 'Ruby',
                    scala: 'Scala',
                    scss: 'SCSS',
                    sql: 'SQL',
                    swift: 'Swift',
                    nolanguage: 'No Language'
                },
                init: function(ready){
                    if ( isBrowserSupported ) {
                        CKEDITOR.scriptLoader.load( path + 'lib/prism/prism.js', function() {
                            ready();
                        });

                        editor.addContentsCss( path + 'lib/prism/prism.css');
                    }
                    // Asynchronous code to load resources and libraries for customEngine.
//                customEngine.loadResources( function() {
                    // Let the editor know that everything is ready.

//                });
                },
                highlighter: function( code, language, callback ) {
                    var result = Prism.highlight(code, Prism.languages[language]);
                    console.log(result);
                    callback(result);
                    // Let the customEngine highlight the code.

//                customEngine.highlight( code, language, function() {
//                    callback(highlightedCode);
//                });
                }
            });

            prismHighlighter.highlight( 'foo()', 'javascript', function( highlightedCode ) {
                console.log( highlightedCode ); // -> <span class="pretty">foo()</span>
            } );

            // From now on, myHighlighter will be used as a Code Snippet
            // highlighter, overwriting the default engine.
            editor.plugins.codesnippet.setHighlighter(prismHighlighter);
        }
    });
})();